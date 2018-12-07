package dersane.hokumus.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dersane.hokumus.model.logtbl;

/**
 *
 * @author vektorel
 */
public class LogIslem {
    Session ss;
    public void kaydet(logtbl t){
    
        ss = hbUtil.getSessionFactory().openSession();
        
        try{
        
            if(ss.isConnected()){
              dbkaydet(t);
            }
            else{
              dosyayakaydet(t);
            }
            
        }catch(Exception ex){
          dosyayakaydet(t);
        }
        
    }
    
    // kaydet method sonu.
    
    private void dbkaydet(logtbl t){
        Transaction tt = ss.beginTransaction();
        ss.save(t);
        tt.commit();
        ss.close();
    }
    
    private void dosyayakaydet(logtbl t){
    
         try{
        File fl = new File("C://log.txt");
            BufferedWriter bf = new BufferedWriter(new FileWriter(fl,true));
            bf.append("Tarih..: "+t.getTarih()+":"+
                    "Sýnýf....: "+t.getSinif()+":"+
                    "Method...: "+t.getMethod()+":"+
                    "Hata.....: "+t.getHataicerigi()
                    );
            bf.newLine();
            bf.close();
          
        }
        catch(Exception ex){
            System.err.println("Hata...:"+ex.toString());
       
        }
    
    }

}// class sonu

