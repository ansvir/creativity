cd ..
mvn install:install-file -Dfile=lib/doubletype.jar -DgroupId=doubletype -DartifactId=doubletype -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/Fontastic.jar -DgroupId=Fontastic -DartifactId=Fontastic -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/sfntly.jar -DgroupId=sfntly -DartifactId=sfntly -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/ImageTracer.jar -DgroupId=ImageTracer -DartifactId=ImageTracer -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/Svg2ttf.jar -DgroupId=Svg2ttf -DartifactId=Svg2ttf -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/potracej.jar -DgroupId=potracej -DartifactId=potracej -Dversion=1.0 -Dpackaging=jar