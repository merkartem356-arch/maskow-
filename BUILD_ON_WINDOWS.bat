@echo off
chcp 65001 >nul
setlocal

echo === Tent Nets - Minecraft Forge 1.21.1 ===
echo Требуется Java 21 и Gradle 8.8 или совместимая версия.

where java >nul 2>nul
if errorlevel 1 (
  echo ОШИБКА: Java не найдена. Установи Java JDK 21.
  pause
  exit /b 1
)
where gradle >nul 2>nul
if errorlevel 1 (
  echo ОШИБКА: Gradle не найден в PATH.
  echo Установи Gradle 8.8, добавь его в PATH и запусти файл снова.
  pause
  exit /b 1
)

for /f "tokens=3" %%v in ('java -version 2^>^&1 ^| findstr /i "version"') do set JAVAVER=%%v
echo Обнаружена Java: %JAVAVER%
echo Запускаю сборку. При первом запуске Gradle скачает зависимости Forge.
gradle --no-daemon build
if errorlevel 1 (
  echo.
  echo СБОРКА НЕ УДАЛАСЬ. Смотри сообщения об ошибках выше.
  pause
  exit /b 1
)

echo.
echo ГОТОВО! JAR находится в папке build\libs.
explorer "%~dp0build\libs"
pause
