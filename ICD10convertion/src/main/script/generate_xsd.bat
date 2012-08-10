cd c:\ICD10
inst2xsd -design ss -verbose ICD10CM_2012_Full_Tabular.xml -outPrefix icd10cm_table_ss -outDir .

inst2xsd -design rd -verbose ICD10CM_2012_Full_Tabular.xml -outPrefix icd10cm_table_rd -outDir .