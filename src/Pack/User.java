package Pack;

class User {
    
    String DOSTUP;
    
    String NAME, STATUS, PROJECT, TEMA_Project, Tip_Project, project_Priory, S_PROJECT, Opisanie;    

    User(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6) {
       this.NAME = string;
        this.STATUS = string0;
        this.PROJECT = string1;
        this.TEMA_Project = string2;
        this.Tip_Project = string3;
        this.project_Priory = string4;
        this.S_PROJECT = string5;
        this.Opisanie = string6; 
    }    

 

    public User(String NAME, String STATUS) {
            this.NAME = NAME;
            this.STATUS = STATUS;
        }
    
    public User(String NAME, String STATUS, String DOSTUP) {
            this.NAME = NAME;
            this.STATUS = STATUS;
            this.DOSTUP = DOSTUP;
        }

    public String getDOSTUP() {
        return DOSTUP;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public String getPROJECT() {
        return PROJECT;
    }

    public String getS_PROJECT() {
        return S_PROJECT;
    }

    public String getTEMA_Project() {
        return TEMA_Project;
    }

    public String getTip_Project() {
        return Tip_Project;
    }

    public String getProject_Priory() {
        return project_Priory;
    }

    public String getOpisanie() {
        return Opisanie;
    }
    
    

    
   
}
  