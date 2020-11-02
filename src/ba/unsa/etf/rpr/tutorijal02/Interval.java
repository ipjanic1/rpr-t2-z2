package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetak, kraj;
    private boolean pocetak_pripada, kraj_pripada;

    Interval () {
        pocetak = 0; kraj = 0;
        pocetak_pripada = false; kraj_pripada = false;
    }

    double getPocetak () {
        return pocetak;
    }

    double getKraj() {
        return kraj;
    }

    void setPocetak(double a) {
        pocetak = a;

    }

    void setKraj (double a) {
        kraj = a;
    }

    void setPripadnostPrve(boolean a) {
        pocetak_pripada = a;

    }

    void setPripadnostDruge (boolean a) {
        kraj_pripada = a;
    }

    boolean getPripadnostPrve () {
        return pocetak_pripada;
    }

    boolean getPripadnostDruge() {
        return kraj_pripada;
    }


    Interval(double t1, double t2, boolean p1, boolean p2) {
        if (t1 > t2) throw new IllegalArgumentException("Nevalidan interval");
        pocetak = t1; kraj = t2; pocetak_pripada = p1; kraj_pripada = p2;
    }

    boolean isNull() {
        if (pocetak == kraj && pocetak_pripada == false && kraj_pripada == false) return true;
        return false;
    }

    boolean isIn(double d) {
        if (d > pocetak && d < kraj) return true;
        if (d == pocetak && this.getPripadnostPrve()) return true;
        if (d == kraj && this.getPripadnostDruge()) return true;
        return false;

    }

    public static Interval intersect (Interval i1, Interval i2) {
        Interval novi = new Interval();
        if (i1.getPocetak() >= i2.getPocetak()) {
            novi.setPocetak(i1.getPocetak());
            if (i1.getPripadnostPrve()) novi.setPripadnostPrve(true);
            else novi.setPripadnostPrve(false);
        }
        else {
            novi.setPocetak(i2.getPocetak());
            if (i2.getPripadnostPrve()) novi.setPripadnostPrve(true);
            else novi.setPripadnostPrve(false);
        }
        if (i1.getKraj() <= i2.getKraj()) {
            novi.setKraj(i1.getKraj());
            if (i1.getPripadnostDruge()) novi.setPripadnostDruge(true);
            else novi.setPripadnostDruge(false);
        }
        else {
            novi.setKraj(i2.getKraj());
            if (i2.getPripadnostDruge()) novi.setPripadnostDruge(true);
            else novi.setPripadnostDruge(false);
        }
        return novi;

    }

    public Interval intersect (Interval i) {
        Interval novi = new Interval();
        if (i.getPocetak() >= this.getPocetak()) {
            novi.setPocetak(i.getPocetak());
            if (i.getPripadnostPrve()) novi.setPripadnostPrve(true);
            else novi.setPripadnostPrve(false);
        }
        else {
            novi.setPocetak(this.getPocetak());
            if (this.getPripadnostPrve()) novi.setPripadnostPrve(true);
            else novi.setPripadnostPrve(false);
        }
        if (i.getKraj() <= this.getKraj()) {
            novi.setKraj(i.getKraj());
            if (i.getPripadnostDruge()) novi.setPripadnostDruge(true);
            else novi.setPripadnostDruge(false);
        }
        else {
            novi.setKraj(this.getKraj());
            if (this.getPripadnostDruge()) novi.setPripadnostDruge(true);
            else novi.setPripadnostDruge(false);
        }
        return novi;

    }
    @Override
    public String toString () {
        if (this.isNull()) {
            return "()";
        }
        if (!pocetak_pripada && !kraj_pripada) {
            return "(" + pocetak + "," + kraj + ")";
        }
        else if (!pocetak_pripada && kraj_pripada) {
            return "(" + pocetak + "," + kraj + "]";
        }
        else if (pocetak_pripada && !kraj_pripada) {
            return "[" + pocetak + "," + kraj + ")";
        }
        else {
            return "[" + pocetak + "," + kraj + "]";
        }
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof Interval) {
            if (((Interval)o).getPocetak() == pocetak && ((Interval)o).getKraj() == kraj && ((Interval)o).getPripadnostPrve() ==
            pocetak_pripada && ((Interval)o).getPripadnostDruge() == kraj_pripada) return true;
        }
        return false;
    }


}
