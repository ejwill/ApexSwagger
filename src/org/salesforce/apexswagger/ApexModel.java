package org.salesforce.apexswagger;

public class ApexModel {
    public String getNameLine() {
        return nameLine;
    }

    public int getInameLine() {
        return inameLine;
    }

    public void setNameLine(String nameLine, int iLine) {
        this.nameLine = nameLine.trim();
        this.inameLine = iLine;
        parseScope();
    }

    public String getDescription() {
        return description == null ? "" : description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author == null ? "" : author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date == null ? "" : date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReturns() {
        return returns == null ? "" : returns;
    }

    public void setReturns(String returns) {
        this.returns = returns;
    }

    public String getExample() {
        return example == null ? "" : example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getScope() {
        return scope == null ? "" : scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    private void parseScope() {
        scope = null;
        if (nameLine != null) {
            String str = ApexSwagger.strContainsScope(nameLine);
            if (str != null)
                scope = str;
        }
    }

    public String getContact() {
        return contact == null ? "" : contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVersion() {
        return version == null ? "" : version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBasePath() {
        return basePath == null ? "" : basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getBaseDescription() {
        return baseDescription == null ? "" : baseDescription;
    }

    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }

    public String getPath() {
        return path == null ? "" : path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBaseUrl() {
        return baseUrl == null ? "" : baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private String nameLine;
    private int inameLine;
    private String description;
    private String author;
    private String date;
    private String returns;
    private String scope;
    private String example;
    private String contact;
    private String version;
    private String basePath;
    private String baseDescription;
    private String path;
    private String baseUrl;

}
