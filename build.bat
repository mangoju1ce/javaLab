@echo off
javac -encoding UTF-8 -d bin/production/SearchEngineForStudent `
    (Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName })
