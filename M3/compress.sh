cd src
find . -name ".DS_Store" -type f -delete
zip -r submission.zip main -x "*/.*" "*/__MACOSX/*"