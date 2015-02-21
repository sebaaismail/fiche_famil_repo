package com.sebaainf.fichfamil.persistance;

import com.jenkov.db.itf.IDaos;
import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.fichfamil.citoyen.Citoyen;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

/**
 * Created by admin on 25/01/2015.
 * Class to create new, update or delete Citoyens
 */
public class MyDaosCitoyen {


    /**
     * *
     *
     * @param num_actnaiss
     * @param annee_naiss
     * @param lieu_naiss
     * @return
     * @should return citoyen with num_actnaiss annee_naiss lieu_naiss parameters
     */

    public static Citoyen getCitoyen(int num_actnaiss, int annee_naiss, int lieu_naiss) throws PersistenceException {

        Citoyen citoyen = null;


        try {
            /*String sql    = "select * from citoyen where num_actnaiss="+new Integer(num_actnaiss).toString()+" and annee_actnaiss="
                    +new Integer(annee_naiss).toString()+" and code_lieunaiss="+new Integer(lieu_naiss).toString();
          */
            String sql = "select * from citoyen where num_actnaiss=" + num_actnaiss + " and annee_actnaiss="
                    + annee_naiss + " and code_lieunaiss=" + lieu_naiss;
            IDaos daos = MyDaos.persistenceManager.createDaos();
            citoyen = daos.getObjectDao().read(Citoyen.class, sql);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return citoyen;
        }
    }

    /**
     * @param id_cit
     * @return
     * @throws com.jenkov.db.itf.PersistenceException
     * @should return citoyen with id_cit
     */
    public static Citoyen getCitoyen(int id_cit) throws PersistenceException {

        Citoyen citoyen = null;


        try {

            String sql = "select * from citoyen where id_cit=?";
            IDaos daos = MyDaos.persistenceManager.createDaos();
            citoyen = daos.getObjectDao().read(Citoyen.class, sql, id_cit);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return citoyen;
        }
    }

    /**
     * @param nom_fr
     * @param prenom_fr
     * @param datenaiss
     * @param lieunaiss
     * @return
     * @should return citoyen with nom prenom date et lieu de naiss unique normalement
     */
    public static Citoyen getCitoyen(String nom_fr, String prenom_fr, Date datenaiss, int lieunaiss) {

        Citoyen citoyen = null;
        try {
            String sql = "select * from citoyen where nom_fr='" + nom_fr +
                    "' and prenom_fr='" + prenom_fr + "' and code_lieunaiss=" + lieunaiss;
            IDaos daos = MyDaos.persistenceManager.createDaos();
            citoyen = daos.getObjectDao().read(Citoyen.class, sql);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return citoyen;
        }

    }

    /**
     * method to add new citoyen to DB if not exist!
     *
     * @param cit
     * @return
     * @should insert citoyen cit into Data base
     */
    public static Citoyen insertCitoyen(Citoyen cit) {

        try {
            IDaos daos = MyDaos.persistenceManager.createDaos();

            if (cit.getAnnee_actnaiss() == 0) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(cit.getDate_naiss());
                cit.setAnnee_actnaiss(calendar.get(Calendar.YEAR));

            }

            if (isInDBCitoyen(cit)) {
                System.out.println("ce citoyen existe deja !");
            } else {

                daos.getObjectDao().insert(cit);
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return cit;

    }

    /**
     * method to check if cit is citoyen, exist in DB
     *
     * @param cit
     * @return
     * @should verifies if cit existe in the data base
     */
    public static boolean isInDBCitoyen(Citoyen cit) {


        boolean flag = false;
        int numactnaiss = cit.getNum_actnaiss();
        int anneenaiss = cit.getAnnee_actnaiss();
        int lieunaiss = cit.getCode_lieunaiss();


        try {
            if (numactnaiss > 0 && anneenaiss > 0 && lieunaiss > 0) {


                if (MyDaosCitoyen.getCitoyen(numactnaiss, anneenaiss, lieunaiss) != null) {

                    flag = true;
                    System.out.println("citoytn existe deja avec les parametres : numactnaiss, anneenaiss, lieunaiss ");
                    return flag;
                }

            }
            String nomfr = cit.getNom_fr();
            String prenomfr = cit.getPrenom_fr();
            Date datenaiss = cit.getDate_naiss();

            if (MyDaosCitoyen.getCitoyen(nomfr, prenomfr, datenaiss, lieunaiss) != null) {
                flag = true;
                System.out.println("citoytn existe deja avec les parametres : nomfr, prenomfr, datenaiss, lieunaiss");
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return flag;

    }

    /**
     * method to update
     *
     * @param cit
     * @return
     * @should update citoyen cit
     */
    public static Citoyen updateCitoyen(Citoyen cit) {

        try {

            IDaos daos = MyDaos.persistenceManager.createDaos();
            daos.getObjectDao().update(cit);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return cit;

    }

    /**
     * method to delete citoyen cit
     *
     * @param cit
     * @return
     * @should delete citoyen cit
     */
    public static boolean deleteCitoyen(Citoyen cit) {

        boolean flag = false;

            try {
                if (isInDBCitoyen(cit)) {
                IDaos daos = MyDaos.persistenceManager.createDaos();
                daos.getObjectDao().delete(cit);
                flag = true;
                    System.out.println("citoyen deleted");
                } else {
                    System.out.println("citoyen not found in data base !!");
                    //todo  ?
                }
            } catch (PersistenceException e) {
                e.printStackTrace();
            } finally {
                System.out.println("flag :" + flag);
                return flag;
            }


}

    /**
     * method to delete citoyen cit
     *
     * @param id_cit
     * @return
     * @should delete citoyen cit by id_cit
     */
    public static boolean deleteCitoyen(int id_cit) {

        boolean flag = false;
        try {
            if (getCitoyen(id_cit) != null) {

                IDaos daos = MyDaos.persistenceManager.createDaos();
                daos.getObjectDao().delete(Citoyen.class, id_cit);
                flag = true;
                System.out.println("citoyen deleted");
            } else {
                //todo not tested method
                System.out.println("citoyen not found in data base !!");

            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            System.out.println("flag :" + flag);
            return flag;
        }

    }

    /**
     * method to test connection with irreport
     * @return
     * @throws PersistenceException
     */
    public static Collection<Citoyen> getCitoyens() throws PersistenceException {

        Vector citoyens = new Vector();
        Citoyen citoyen = null;

        int num_actnaiss = 88;
        int annee_naiss = 1970;
        int lieu_naiss = 31001;


        try {
            /*String sql    = "select * from citoyen where num_actnaiss="+new Integer(num_actnaiss).toString()+" and annee_actnaiss="
                    +new Integer(annee_naiss).toString()+" and code_lieunaiss="+new Integer(lieu_naiss).toString();
          */
            String sql = "select * from citoyen where num_actnaiss=" + num_actnaiss + " and annee_actnaiss="
                    + annee_naiss + " and code_lieunaiss=" + lieu_naiss;
            IDaos daos = MyDaos.persistenceManager.createDaos();
            citoyen = daos.getObjectDao().read(Citoyen.class, sql);
            citoyens.add(citoyen);

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return citoyens;
        }
    }

}
