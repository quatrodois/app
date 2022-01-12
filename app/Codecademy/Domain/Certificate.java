package app.Codecademy.Domain;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.Codecademy.DB.CertificateSql;
import app.Codecademy.DB.SqlManager;
public class Certificate {
    private int certificateID;
    private float grade;
    private String signatoryName;
    protected ArrayList < Certificate > certificateInfo;

    public Certificate(int certificateID, float grade, String signatoryName) {
        this.certificateInfo = new ArrayList < > ();
        this.certificateID = certificateID;
        this.grade = grade;
        this.signatoryName = signatoryName;
    }
    SqlManager manager = new SqlManager();
    CertificateSql certificateSql = new CertificateSql();
    // give this class access to the functions in SqlManager and CertificateSqlSqlManager manager = new SqlManager();CertificateSql certificateSql = new CertificateSql();
    public void getModuleResult() {
        ResultSet certificateRS = manager.executeSql(certificateSql.selectCertificateInRegistrationSql());
        try {
            while (certificateRS.next()) {
                Certificate certificate = new Certificate(certificateRS.getInt("certificateID"), certificateRS.getFloat("grade"), certificateRS.getString("signatoryName"));
                certificateInfo.add(certificate);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateCertificate(int ID, String input) {
        manager.executeSql(certificateSql.updateCertificateSql(ID, input));
    }
    public void insertCertificate(String[] input) {
        manager.executeSql(certificateSql.insertCertificateSql(input));
    }
    public void deleteCertificate(String ID) {
        manager.executeSql(certificateSql.deleteCertificateSql(ID));
    }
    public int getCertificateID() {
        return certificateID;
    }
    public float getGrade() {
        return grade;
    }
    public String getSignatoryName() {
        return signatoryName;
    }
    public List < String > getStudentCertificates(String email) {
        List < String > listc = new ArrayList < > ();
        CertificateSql cer = new CertificateSql();
        ResultSet cSpecStudent = manager.executeSql(cer.selectCertificatesEarnedSql(email));
        try {
            while (cSpecStudent.next()) {
                String courseName = cSpecStudent.getString("courseName");
                listc.add(courseName);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Hier");
        }
        return listc;
    }
}