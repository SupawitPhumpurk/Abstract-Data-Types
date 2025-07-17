package Lib;
import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet{
  ArrayList<Integer>numbers; //Rep
/**ADT ที่เก็บ character แบบไม่ซ้ำกันและเรียงลำดับ
 */
    // Rep Invariant (RI):
    //  - s must not contain duplicate int.
    //  - int in s must be sorted in ascending order.
    //
    // Abstraction Function (AF):
    //  - AF(s) = the set of numbers in the int x.

    /**
     * Constructor เริ่มต้น สร้างเซตว่าง
     */
    public IntegerSet() {
        numbers = new ArrayList<>();
    }
    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
 
    private void checkRep(){
      if (numbers == null ) {
            throw new RuntimeException("numbers Must no Empty");
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i)>=(numbers.get(i + 1)) ) {
                throw new RuntimeException("Rep invariant violated!");
            }
        }
      }
    /**
     * เพิ่มตัวเลขเข้าเซต
     * @param int ตัวเลขที่ต้องการเพิ่ม
     * @throws Exception 
     */   
    public void add(Integer x) {
       if (numbers == null) throw new NullPointerException("null not allowed");
        int idx = Collections.binarySearch(numbers, x);
        if (idx >= 0) return; // มีแล้ว ไม่ทำไร
        int insertPos = -idx - 1;
        numbers.add(insertPos, x);
        checkRep();
    }
       /**
     * ลบตัวเลขเข้าเซต
     * @param int ตัวเลขที่ต้องการลบ
     */   
    public  void remove(Integer x) {
       if (x == null) return;
        numbers.remove(x);
        checkRep();
    }
    /**
     * ตรวจสอบว่ามีตัวเลขนี้อยู่ในเซตหรือไม่
     * @param x ตัวเลขที่ต้องการตรวจสอบ
     * @return true หากมี xอยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer x){
      if (x == null) return false;
        return Collections.binarySearch(numbers, x) >= 0;
    }

  public int size() {
        return numbers.size();
    }
      /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกในเซต
     */
    public String toString(){
        return numbers.toString();
    }
 
    }
  