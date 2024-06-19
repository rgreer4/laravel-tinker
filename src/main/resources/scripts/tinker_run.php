/*<?php /**/

use Illuminate\Contracts\Console\Kernel;
use Laravel\Tinker\ClassAliasAutoloader;
use Psy\Configuration;
use Psy\ExecutionLoopClosure;
use Psy\Shell;
use Symfony\Component\Console\Output\ConsoleOutput;

define('LARAVEL_START', microtime(true));

echo "%%START-OUTPUT%%";

$projectSettings = json_decode($argv[2]) ?? new stdClass();

require ($projectSettings->vendorRoot ?: __DIR__) . '/vendor/autoload.php';
$app = require_once ($projectSettings->laravelRoot ?: __DIR__) . '/bootstrap/app.php';
$kernel = $app->make(Kernel::class);
$kernel->bootstrap();

$config = new Configuration([
    'updateCheck' => 'never',
    'usePcntl' => false,
    'useReadline' => false,
    'prompt' => '',
    'theme' => 'compact',
]);
if (method_exists($config, 'setRawOutput')) {
    $config->setRawOutput(true);
}
if (method_exists($config, 'setInteractiveMode')) {
    $config->setInteractiveMode(Configuration::INTERACTIVE_MODE_DISABLED);
}
$config->setColorMode(Configuration::COLOR_MODE_FORCED);

$casters = [
    'Illuminate\Support\Collection' => 'Laravel\Tinker\TinkerCaster::castCollection',
    'Illuminate\Support\HtmlString' => 'Laravel\Tinker\TinkerCaster::castHtmlString',
    'Illuminate\Support\Stringable' => 'Laravel\Tinker\TinkerCaster::castStringable',
    'Illuminate\Database\Eloquent\Model' => 'Laravel\Tinker\TinkerCaster::castModel',
    'Illuminate\Foundation\Application' => 'Laravel\Tinker\TinkerCaster::castApplication',
    'Illuminate\Process\ProcessResult' => 'Laravel\Tinker\TinkerCaster::castProcessResult',
];

$existingCasters = [];
foreach($casters as $castableClass => $casterMethod) {
    list($casterClass, $casterClassMethod) = explode('::', $casterMethod);
    if(class_exists($castableClass) && method_exists($casterClass, $casterClassMethod)) {
        $existingCasters[$castableClass] = $casterMethod;
    }
}

$config->getPresenter()->addCasters($existingCasters);
$config->setHistoryFile(defined('PHP_WINDOWS_VERSION_BUILD') ? 'nul' : '/dev/null');

$shell = new Shell($config);
$output = new ConsoleOutput();
$shell->setOutput($output);
$closure = new ExecutionLoopClosure($shell);

$autoloadClassMap = ($projectSettings->vendorRoot ?: __DIR__) . '/vendor/composer/autoload_classmap.php';
if(class_exists('\Laravel\Tinker\ClassAliasAutoloader')) {
    $loader = ClassAliasAutoloader::register($shell, $autoloadClassMap);
}

$unsanitizedRunCode = token_get_all($argv[1]);
$sanitizedRunCode = '';
foreach($unsanitizedRunCode as $token) {
    if (!is_string($token)) {
        list($id, $token) = $token;
        if (in_array($id, [T_COMMENT, T_DOC_COMMENT, T_OPEN_TAG, T_OPEN_TAG_WITH_ECHO, T_CLOSE_TAG], true)) {
            continue;
        }
    }

    $sanitizedRunCode .= $token;
}

$shell->addInput($sanitizedRunCode, true);
if($projectSettings->terminateApp) {
    $shell->addInput('echo "%%END-OUTPUT%%";', true);
    $shell->addInput('app()->terminate();', true);
}
$shell->addInput('usleep(250000); throw new \Psy\Exception\BreakException("%%END-OUTPUT%%");', true);
$closure->execute();

if(isset($loader)) {
    $loader->unregister();
}
