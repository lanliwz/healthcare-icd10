java -Durl=http://localhost:8983/solr/update/csv -Dcommit=no -jar post.jar icd10pcs_tabular_2013.csv
java -Durl=http://localhost:8983/solr/update/csv -Dcommit=no -jar post.jar icd10cm_tabular_2012.csv
java -Durl=http://localhost:8983/solr/update/csv -Dcommit=no -jar post.jar icd9_dx.csv
java -Durl=http://localhost:8983/solr/update/csv -Dcommit=no -jar post.jar icd9_sg.csv
java -Durl=http://localhost:8983/solr/update/csv -Dcommit=no -jar post.jar icd9_10gem.csv
java -Durl=http://localhost:8983/solr/update/csv -Dcommit=no -jar post.jar icd10_9gem.csv

java -Durl=http://localhost:8983/solr/update -Dcommit=yes -jar post.jar