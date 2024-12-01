class Mattone {
    private String id;
    private String lotto;
    public Mattone(String id){
        id=id;
    }
    
    public void setLotto(String l){
        lotto=l;
    }

    public String getString() {
         return "mattone n."+lotto+" l."+id;
    }
}
