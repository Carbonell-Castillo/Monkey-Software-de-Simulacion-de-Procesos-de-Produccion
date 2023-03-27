/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author bruce
 */
public class SG {
    
    public static Integer tiempoInventario=3000;
    public static Integer tiempoProduccion=5000;
    public static Integer tiempoEmpaquetado=8000;
    public static Integer tiempoSalida=1000;
    public static Integer tiempoTotal=0;
    
    public static Integer totalPagar=0;
    
    public static Integer nPelotas=2;
    
    public static Integer nInicio=10;
    public static Integer nInventario=0;
    public static Integer nProduccion=0;
    public static Integer nEmpaquetado=0;
    public static Integer nSalida=0;
    public static Integer nFinal=0;
    
    public static Integer costoInventario=10;
    public static Integer costoProduccion=10;
    public static Integer costoEmpaquetado=10;
    public static Integer costoSalida=10;
    
    public static Materias materias = new Materias();
    
    public static interfaz2 interfaz= new interfaz2();
    
    
    public static void generateReport() throws IOException{
        String fname="";

        String content = "<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Document</title>\n" +
"</head>\n" +
"<body>\n" +
"    <style>\n" +
"\n" +
"        *{\n" +
"    box-sizing: border-box;\n" +
"    -webkit-box-sizing: border-box;\n" +
"    -moz-box-sizing: border-box;\n" +
"}\n" +
"body{\n" +
"    font-family: Helvetica;\n" +
"    -webkit-font-smoothing: antialiased;\n" +
"    background: rgba( 71, 147, 227, 1);\n" +
"}\n" +
"h2{\n" +
"    text-align: center;\n" +
"    font-size: 18px;\n" +
"    text-transform: uppercase;\n" +
"    letter-spacing: 1px;\n" +
"    color: white;\n" +
"    padding: 30px 0;\n" +
"}\n" +
"\n" +
"/* Table Styles */\n" +
"\n" +
".table-wrapper{\n" +
"    margin: 10px 70px 70px;\n" +
"    box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );\n" +
"}\n" +
"\n" +
".fl-table {\n" +
"    border-radius: 5px;\n" +
"    font-size: 12px;\n" +
"    font-weight: normal;\n" +
"    border: none;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"    max-width: 100%;\n" +
"    white-space: nowrap;\n" +
"    background-color: white;\n" +
"}\n" +
"\n" +
".fl-table td, .fl-table th {\n" +
"    text-align: center;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
".fl-table td {\n" +
"    border-right: 1px solid #f8f8f8;\n" +
"    font-size: 12px;\n" +
"}\n" +
"\n" +
".fl-table thead th {\n" +
"    color: #ffffff;\n" +
"    background: #4FC3A1;\n" +
"}\n" +
"\n" +
"\n" +
".fl-table thead th:nth-child(odd) {\n" +
"    color: #ffffff;\n" +
"    background: #324960;\n" +
"}\n" +
"\n" +
".fl-table tr:nth-child(even) {\n" +
"    background: #F8F8F8;\n" +
"}\n" +
"h3{\n" +
"    color: #ffffff;\n" +
"    \n" +
"}\n" +
"/* Responsive */\n" +
"\n" +
"@media (max-width: 767px) {\n" +
"    .fl-table {\n" +
"        display: block;\n" +
"        width: 100%;\n" +
"    }\n" +
"    .table-wrapper:before{\n" +
"        content: \"Scroll horizontally >\";\n" +
"        display: block;\n" +
"        text-align: right;\n" +
"        font-size: 11px;\n" +
"        color: white;\n" +
"        padding: 0 0 10px;\n" +
"    }\n" +
"    .fl-table thead, .fl-table tbody, .fl-table thead th {\n" +
"        display: block;\n" +
"    }\n" +
"    .fl-table thead th:last-child{\n" +
"        border-bottom: none;\n" +
"    }\n" +
"    .fl-table thead {\n" +
"        float: left;\n" +
"    }\n" +
"    .fl-table tbody {\n" +
"        width: auto;\n" +
"        position: relative;\n" +
"        overflow-x: auto;\n" +
"    }\n" +
"    .fl-table td, .fl-table th {\n" +
"        padding: 20px .625em .625em .625em;\n" +
"        height: 60px;\n" +
"        vertical-align: middle;\n" +
"        box-sizing: border-box;\n" +
"        overflow-x: hidden;\n" +
"        overflow-y: auto;\n" +
"        width: 120px;\n" +
"        font-size: 13px;\n" +
"        text-overflow: ellipsis;\n" +
"    }\n" +
"    .fl-table thead th {\n" +
"        text-align: left;\n" +
"        border-bottom: 1px solid #f7f7f9;\n" +
"    }\n" +
"    .fl-table tbody tr {\n" +
"        display: table-cell;\n" +
"    }\n" +
"    .fl-table tbody tr:nth-child(odd) {\n" +
"        background: none;\n" +
"    }\n" +
"    .fl-table tr:nth-child(even) {\n" +
"        background: transparent;\n" +
"    }\n" +
"    .fl-table tr td:nth-child(odd) {\n" +
"        background: #F8F8F8;\n" +
"        border-right: 1px solid #E6E4E4;\n" +
"    }\n" +
"    .fl-table tr td:nth-child(even) {\n" +
"        border-right: 1px solid #E6E4E4;\n" +
"    }\n" +
"    .fl-table tbody td {\n" +
"        display: block;\n" +
"        text-align: center;\n" +
"    }\n" +
"}\n" +
"    </style>\n" +
"    <h2>Datos</h2>\n" +
"<div class=\"table-wrapper\">\n" +
"    <table class=\"fl-table\">\n" +
"        <thead>\n" +
"        <tr>\n" +
"            <th>Datos</th>\n" +
"            <th>Inventario</th>\n" +
"            <th>Produccion</th>\n" +
"            <th>Empaquetado</th>\n" +
"            <th>Salida</th>\n" +
"            <th>Total</th>\n" +
"        </tr>\n" +
"        </thead>\n" +
"        <tbody>\n" +
"        <tr>\n" +
"            <td>Tiempos</td>\n" +
"            <td>"+tiempoInventario/1000+"s</td>\n" +
"            <td>"+tiempoProduccion/1000+"s</td>\n" +
"            <td>"+tiempoEmpaquetado/1000+"s</td>\n" +
"            <td>"+tiempoSalida/1000+"s</td>\n" +
"            <td>"+tiempoTotal+"s</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Costos</td>\n" +
"            <td>Q "+costoInventario+"</td>\n" +
"            <td>Q "+costoProduccion+"</td>\n" +
"            <td>Q "+costoEmpaquetado+"</td>\n" +
"            <td>Q "+costoSalida+"</td>\n" +
"            <td>Q "+totalPagar+"</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Totales</td>\n" +
"            <td>Q "+(tiempoInventario/1000*costoInventario)+"</td>\n" +
"            <td>Q "+(tiempoProduccion/1000*costoProduccion)+"</td>\n" +
"            <td>Q "+(tiempoEmpaquetado/1000*costoEmpaquetado)+"</td>\n" +
"            <td>Q "+(tiempoSalida/1000*costoSalida)+"</td>\n" +
"            <td>Q "+(tiempoTotal*totalPagar)+"</td>\n" +
"        </tr>\n" +
"        \n" +
"        <tbody>\n" +
"    </table>\n" +
"    \n" +
"    <h3>Total neto: Q"+(tiempoTotal*totalPagar)+" </h3>\n" +
"    <h3>#202203069 - Bruce Carbonell Castillo Cifuentes</h3>\n" +
"   <br>\n" +
"</div>\n" +
"</body>\n" +
"</html>";

        // Escribe el contenido en un archivo HTML
        Files.write(Paths.get("file.html"), content.getBytes(StandardCharsets.UTF_8));

        // Abre el archivo HTML en el navegador predeterminado
        File file = new File("file.html");
        Desktop.getDesktop().browse(file.toURI());
    }
    
}
