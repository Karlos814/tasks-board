call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo runcrud has errors - breaking work
goto fail

:browser
start http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo browser has errors - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.