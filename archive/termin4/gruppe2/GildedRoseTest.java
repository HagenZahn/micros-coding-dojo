import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hagen.zahn
 * Date: 24.01.13
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class GildedRoseTest {

    @Test
    public void testNormalItemBeforeSellInIsReached() throws Exception {
        Item item = new Item("normal", 10, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(19, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void testNormalItemAfterSellInIsReached() throws Exception {
        Item item = new Item("normal", 0, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(18, item.quality);
    }

    @Test
    public void testAgedBrieBeforeSellInIsReached() throws Exception {
        Item item = new Item(GildedRose.AGED_BRIE, 10, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(21, item.quality);
    }

    @Test
    public void testAgedBrieAfterSellInIsReached() throws Exception {
        Item item = new Item(GildedRose.AGED_BRIE, 0, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(22, item.quality);
    }
    @Test
    public void testQualityMax() throws Exception {
        Item item = new Item(GildedRose.AGED_BRIE, 10, 50);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(50, item.quality);
    }
    @Test
    public void testQualityMin() throws Exception {
        Item item = new Item("normal", 10, 0);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }
    @Test
    public void testWrongQualityMin() throws Exception {
        Item item = new Item("normal", 10, -1);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(-1, item.quality);
    }
    @Test
    public void testBackStageGreaterThan10() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 11, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(21, item.quality);
    }
    @Test
    public void testBackStageEqual10() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 10, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(22, item.quality);
    }
    @Test
    public void testBackStageGreaterThan5() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 6, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(22, item.quality);
    }
    @Test
    public void testBackStageEqual5() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 5, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(23, item.quality);
    }
    @Test
    public void testBackStageEqual0() throws Exception {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 0, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }
    @Test
    public void testSulfurasNeverChange() throws Exception {
        Item item = new Item(GildedRose.SULFURAS, 10, 20);
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        assertEquals(20, item.quality);
        assertEquals(10, item.sellIn);
    }

}
