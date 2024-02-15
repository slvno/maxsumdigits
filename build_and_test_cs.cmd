rem %comspec% /k "C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\Common7\Tools\VsDevCmd.bat"
rem wget https://dist.nuget.org/win-x86-commandline/latest/nuget.exe -O nuget.exe
rem .\nuget.exe install Microsoft.Net.Compilers

csc.exe /t:exe /r:System.dll /r:System.Core.dll /r:System.Numerics.dll /out:get_max_value_from_input.exe get_max_value_from_input.cs
rem csc.exe /t:exe -r:System.dll /r:System.Core.dll -d:TRACE -d:DEBUG=TRUE /r:System.Numerics.dll /out:get_max_value_from_input.exe get_max_value_from_input.cs
get_max_value_from_input.exe < test_values.txt

