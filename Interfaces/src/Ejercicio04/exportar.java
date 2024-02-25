package Ejercicio04;

interface Exportable {
 void exportarDatos();
}


class ReporteCSV implements Exportable {
 @Override
 public void exportarDatos() {

     System.out.println("Exportando datos a CSV...");
 }
}


class ReportePDF implements Exportable {
 @Override
 public void exportarDatos() {
 
     System.out.println("Exportando datos a PDF...");
 }
}


public class exportar {
 public static void main(String[] args) {
   
     Exportable reporteCSV = new ReporteCSV();
     reporteCSV.exportarDatos(); 

     Exportable reportePDF = new ReportePDF();
     reportePDF.exportarDatos();
 }
}
