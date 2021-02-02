
package workbase;

/**
 * Головний клас для роботи з даними БД
 * @author User
 */
public class jobs {
    private int id;
    private String name;
    private String area;
    private String edu;
    private String exp;
    private String number;

    public jobs(int id, String name, String area,String edu, String exp, String number) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.edu = edu;
        this.exp = exp;
        this.number = number;        
    }

    //public Customer() {
    //}
    /**
     * 
     * @return ID вакансії
     */
    public int getId() {
        return id;
    }
    /**
     * встановлює параметр id вакансії
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * повертає назву вакансії
     * @return назву вакансії
     */
    public String getName() {
        return name;
    }
    /**
     * встановлює параметр назви вакансії
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * повертає сферу вакансії
     * @return сфера вакансії 
     */
    public String getArea(){
        return area;
    }
    /**
     * встановлює параметр сфери вакансії
     * @param area 
     */
    public void setArea(String area) {
        this.area = area;
    }
    /**
     * повертає контактний номер вакансії
     * @return контактний номер вакансії
     */
    public String getNumber() {
        return number;
    }
    /**
     * встановлює параметр контактного номеру вакансії
     * @param number 
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * повертає інформацію про потрібну освіту
     * @return інформацію про потрібну освіту
     */
    public String getEdu() {
        return edu;
    }
    /**
     * встановлює інформацію про потрібну освіту
     * @param edu
     */
    public void setEdu(String edu) {
        this.edu = edu;
    }
    /**
     * повертає потрібний досвід роботи
     * @return досвід роботи
     */
    public String getExp(){
        return exp;
    }
    /**
     * встановлює параметр досвіду роботи
     * @param exp
     */
    public void setExp(String exp) {
        this.exp = exp;
    }
   
}
