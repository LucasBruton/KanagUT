JC = javac -implicit:none -d build -classpath build -sourcepath "src"

clean: 
	rm -rf build/*

run:
	java -classpath build Model.Main

classes: Listeners Model Vue

Listeners:
	$(JC) src/Listeners/*.java

Model:
	$(JC) src/Model/*.java

Vue:
	$(JC) src/Vue/*.java

