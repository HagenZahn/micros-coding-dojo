import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hagen.zahn
 * Date: 30.01.13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
public class GildedRoseTest {

    // Object under test
    private GildedRose gildedRose;

    @Test
    public void testNormalItemBeforeSellIn () {
        Item item = new Item("Item", 10 ,10);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    public void testNormalItemAfterSellin() {
        Item item = new Item("Item", 0 ,10);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    public void testThatQualityCanNeverBeNegativeBeforeSellin() {
        Item item = new Item("Item", 1 , -1);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(0, item.sellIn);
        assertEquals(-1, item.quality);
    }

    @Test
    public void testThatQualityCanNeverBeNegativeAfterSellin() {
        Item item = new Item("Item", 1 ,0);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertTrue(0 <= item.quality);
    }

    @Test (expected = NullPointerException.class)
    public
    void nullItemThrowsException() {
        gildedRose = new GildedRose(null);
        gildedRose.updateQuality();
    }

    @Test
    public void testMultipleUpdates() {
        Item item = new Item("Item", 6 , 6);
        gildedRose = new GildedRose(item);

        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertEquals(2, item.quality);
        assertEquals(2, item.sellIn);
    }

    @Test
    public void testAgedBrie() throws Exception {
        Item item = new Item(GildedRose.AGED_BRIE, 10 ,10);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(11, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void testBackstagePasses() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 20 ,20);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(21, item.quality);
        assertEquals(19, item.sellIn);
    }

    @Test
    public void testBackstagePassesWith10DaysLeft() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 10 ,10);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(12, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void testBackstagePassesWith5DaysLeft() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 5 ,5);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(8, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void testBackstagePassesWith0DaysLeft() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 0 ,10);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void testQualityNeverMoreThanFifty() throws Exception {
        Item item = new Item(GildedRose.AGED_BRIE, 10 ,50);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(50, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void testSulfuras() throws Exception {
        Item item = new Item(GildedRose.SULFURAS, 10, 10);
        gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(10, item.quality);
        assertEquals(10, item.sellIn);
    }
}
