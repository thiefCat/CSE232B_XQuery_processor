for i in {1..10}; do
    java -cp "classes:lib/*" main.Main data/j_caesar.xml data/query/q$i.txt data/result/q$i.xml
done