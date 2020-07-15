package com.example.smartfan;

public class Settings_Advice_Versions {

    private String codeName, version, apilevel, description;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public Settings_Advice_Versions(String codeName, String version, String apilevel, String description) {
        this.codeName = codeName;
        this.version = version;
        this.apilevel = apilevel;
        this.description = description;
        this.expandable = false;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String vseion) {
        this.version = vseion;
    }

    public String getApilevel() {
        return apilevel;
    }

    public void setApilevel(String apilevel) {
        this.apilevel = apilevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Settings_Advice_Versions{" +
                "codeName='" + codeName + '\'' +
                ", version='" + version + '\'' +
                ", apilevel='" + apilevel + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
