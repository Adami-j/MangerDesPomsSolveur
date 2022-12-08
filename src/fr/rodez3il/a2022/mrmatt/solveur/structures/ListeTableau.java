package fr.rodez3il.a2022.mrmatt.solveur.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListeTableau<E> implements Liste<E>, Cloneable {

    private static final int TAILLEINIT = 20;

    private int tailleDebut=0;

    private int tailleMaxInitiale=0;

    private E element;

    private Object[] object;

    public ListeTableau(int tailleTab) {
        if (tailleTab<=0){
            this.tailleDebut = 0;
            object= new Object[this.TAILLEINIT];
        }else {
            this.tailleDebut=0;
            object= new Object[tailleTab];
        }

    }

    public ListeTableau() {
            this.tailleDebut=0;
            this.tailleMaxInitiale=TAILLEINIT;
            object= new Object[this.TAILLEINIT];

    }



    @Override
    public void ajouter(E element) {

        this.object[this.tailleDebut] = element;
        this.tailleDebut++;
        if(this.tailleDebut>=this.tailleMaxInitiale){
            this.tailleMaxInitiale=this.tailleDebut;
        }
    }

    @Override
    public boolean estVide() {
        return this.tailleDebut==0?true:false;
    }

    @Override
    public int taille() {
        return this.tailleDebut;
    }

    @Override
    public E enlever(int i) {
        int compteur = 0;
        Object[] objects = new Object[this.tailleDebut];
        E objetE;

        for(Object object : this.object){
            if(i!=compteur){
                objects[compteur]= object;

            }else {
                return  objetE=(E)object;
            }

            compteur++;
        }

        return null;

    }

    @Override
    public E element(int i) throws ArrayIndexOutOfBoundsException {
        if(this.object.length-1>i){
           return (E)this.object[i];
        }else {
            throw new ArrayIndexOutOfBoundsException("La valeur saisie n'est pas un index du tableau");
        }
    }

    @Override
    public boolean contient(E e) {
        for(Object element : this.object){
            if((E)element==e){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList arrayList =new ArrayList(15);
        System.out.println(arrayList.size());

        ListeTableau listeTableau = new ListeTableau(0);

        listeTableau.ajouter(1);

        ListeTableau<String> listeTableau1 = new ListeTableau<>();
        listeTableau1.ajouter("");
        listeTableau1.ajouter("coucou");
        listeTableau.ajouter("aha");
        System.out.println(listeTableau.estVide());
        System.out.println(listeTableau1.contient("ahaa"));


    }
}