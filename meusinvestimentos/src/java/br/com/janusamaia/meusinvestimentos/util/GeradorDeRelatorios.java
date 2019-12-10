/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.util;

import br.com.janusamaia.meusinvestimentos.dao.DataSource;
import java.io.OutputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 *
 * @author janus
 */
public class GeradorDeRelatorios {
    
    private DataSource dataSource;
    
    public GeradorDeRelatorios(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void geraPdf(String jrxml,
            Map<String, Object> parametros, OutputStream saida) {

        try {
            JasperReport jasper = JasperCompileManager.compileReport(jrxml);

            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, dataSource.getConnection());
            
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(print));System.out.println(print);
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(saida));
            
            exporter.exportReport();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório", e);
        }
    }  
}
