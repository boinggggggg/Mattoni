public class Produzione implements Runnable {

    private int codiceThreadProduttore;
    private ArrayList<Mattone> mattoniStampatiList;
    private Forno forno;
    private StringBuilder strB;

    public ProduttoreMattoni(int codiceThreadProduttore, Forno f, StringBuilder strBuilder) {
        this.codiceThreadProduttore = codiceThreadProduttore;
        forno = f;
        this.strB=strBuilder;
    }

    @Override
    public void run() {
        try {
            String result;
            Impastatore i = new Impastatore(codiceThreadProduttore);
            result=i.Impasta();
            System.out.println(result);
            strB.append(result);strB.append(System.getProperty("line.separator"));
            RulloStampante r = new RulloStampante(codiceThreadProduttore);
            result=r.StampaMattoni();
            System.out.println(result);
            strB.append(result);strB.append(System.getProperty("line.separator"));
            mattoniStampatiList = r.TrasportaMattoni();
            result=forno.Inforna(mattoniStampatiList,codiceThreadProduttore);
            strB.append(result);strB.append(System.getProperty("line.separator"));
            result=forno.Cuoci();
            strB.append(result);strB.append(System.getProperty("line.separator"));
        } catch (InterruptedException ex) {
            Logger.getLogger(ProduttoreMattoni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Mattone> getMattoniList() {
        return mattoniStampatiList;
    }

}
