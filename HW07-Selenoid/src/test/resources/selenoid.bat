if($docker version){
cd C:\users\%USERNAME%
mkdir qaOtus
cd qaOtus
curl -A "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64)" -L "https://github.com/aerokube/cm/releases/download/1.7.2/cm_windows_amd64.exe" -o cm.exe
cm.exe selenoid start --vnc --browsers "chrome" --last-versions 3 --args "-limit 4" --force
cm.exe selenoid-ui start
}
else{
cd C:\users\%USERNAME%
mkdir qaOtus
curl -fsSL https://get.docker.com -o get-docker.sh
sh get-docker.sh
curl -A "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64)" -L "https://github.com/aerokube/cm/releases/download/1.7.2/cm_windows_amd64.exe" -o cm.exe
cm.exe selenoid start --vnc --browsers "chrome" --last-versions 3 --args "-limit 4" --force
cm.exe selenoid-ui start
}