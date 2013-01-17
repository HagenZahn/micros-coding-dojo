import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testUpdateQualityForAgedBrieBeforeSellIn() {
        Item agedBrie = new Item(GildedRose.AGED_BRIE, 10, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
        gildedRose.updateQuality();
        assertThat(agedBrie.quality, equalTo(41));
    }

    @Test
    public void testUpdateQualityForAgedBrieAfterSellIn() {
        Item agedBrie = new Item(GildedRose.AGED_BRIE, 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
        gildedRose.updateQuality();
        assertThat(agedBrie.quality, equalTo(42));
    }

    @Test
    public void testUpdateQualityForRegularItemBeforeSellIn() {
        Item item = new Item("Regular Item", 10, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(39));
    }

    @Test
    public void testUpdateQualityForRegularItemAfterSellIn() {
        Item item = new Item("Regular Item", 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(38));
    }

    @Test
    public void testUpdateQualityForSulfurasBeforeSellIn() {
        Item item = new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 10, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(40));
    }

    @Test
    public void testUpdateQualityForSulfurasAfterSellIn() {
        Item item = new Item(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(40));
    }




    @Test
    public void testUpdateQualityForBackstagePassesLongBeforeSellIn() {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 100, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(41));
    }

    @Test
    public void testUpdateQualityForBackstagePassesTenDaysBeforeSellIn() {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 10, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(42));
    }
    @Test
    public void testUpdateQualityForBackstagePassesFiveDaysBeforeSellIn() {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 5, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(43));
    }

    @Test
    public void testUpdateQualityForBackstagePassesAfterSellIn() {
        Item item = new Item(GildedRose.BACKSTAGE_PASSES, 0, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertThat(item.quality, equalTo(0));
    }


}