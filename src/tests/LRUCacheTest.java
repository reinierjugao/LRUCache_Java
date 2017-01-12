import static org.junit.Assert.*;
import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void TestAddSmallCache() {
    LRUCache obj = new LRUCache(10);
    String key = "";
    String val = "";
    String newval = "";
    for (int x = 1; x < 100; x++) {
      key = Integer.toString(x);
      val = key;
      obj.put(key, val);
      assertEquals(val, obj.get(key));

      newval = val + "A";
      obj.put(key, newval);
      assertEquals(newval, obj.get(key));

      obj.put(key, val);
      assertEquals(val, obj.get(key));
    }

    for (int x = 1; x < 90; x++) {
      assertEquals("Key does not exist", obj.get("1"));
    }

    for (int x = 500; x < 510; x++) {
      key = Integer.toString(x);
      val = key;
      obj.put(key, val);
    }

    for (int x = 500; x < 510; x++) {
      key = Integer.toString(x);
      val = key;
      assertEquals(val, obj.get(key));
    }
  }

  @Test
  public void TestAddLargeCache() {
    Integer cachesize = 9020000;
    LRUCache obj = new LRUCache(cachesize);
    String key = "";
    String val = "";
    String newval = "";
    for (int x = 1; x < cachesize + 50; x++) {
      key = Integer.toString(x);
      val = key;
      obj.put(key, val);
      assertEquals(val, obj.get(key));

      newval = val + "A";
      obj.put(key, newval);
      assertEquals(newval, obj.get(key));

      obj.put(key, val);
      assertEquals(val, obj.get(key));
    }
  }

  @Test
  public void TestGetLFU() {
    // this will pass an LFU cache but will fail LRU
    Integer cachesize = 10;
    LRUCache obj = new LRUCache(cachesize);
    obj.put("1","1");
    obj.put("1","1");
    obj.put("1","1");
    obj.put("1","1");
    obj.put("2","2");
    obj.put("3","3");
    obj.put("4","4");
    obj.put("5","5");
    obj.put("6","6");
    obj.put("7","7");
    obj.put("8","8");
    obj.put("9","9");
    obj.put("10","10");
    obj.put("11","11");

    assertEquals("Key does not exist", obj.get("1"));
    assertEquals("2", obj.get("2"));
  }


}
