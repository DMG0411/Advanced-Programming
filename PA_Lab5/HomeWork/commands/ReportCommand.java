package HomeWork.commands;

import java.awt.*;
import java.io.*;

import HomeWork.Catalog;
import HomeWork.Document;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.util.*;
import java.util.List;

public class ReportCommand implements Command {
    private final Catalog catalog;
    private final String output;

    public ReportCommand(Catalog catalog, String output) {
        this.catalog = catalog;
        this.output = output;
    }

    @Override
    public void execute() throws IOException, TemplateException {
        String htmlReport = genHtmlReport();
        try(Writer writer = new FileWriter(output)){
            writer.write(htmlReport);
        }
        Desktop.getDesktop().browse(new File(output).toURI());
    }

    public String genHtmlReport() throws TemplateException, IOException{
        Configuration config = new Configuration(Configuration.VERSION_2_3_30);
        config.setClassForTemplateLoading(getClass(), "/");
        config.setDefaultEncoding("UTF-8");
        Template template = config.getTemplate("report.ftl");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("documents", catalog.getDocuments());
        StringWriter stringWriter = new StringWriter();
        template.process(dataModel,stringWriter);
        return stringWriter.toString();
    }
}
