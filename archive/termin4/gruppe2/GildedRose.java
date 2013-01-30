
class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!SULFURAS.equals(item.name)) {
                if (AGED_BRIE.equals(item.name)) {
                    increaseQuality(item);
                } else if (BACKSTAGE_PASSES.equals(item.name)) {
                    updateQualityBackstagePasses(item);
                } else {
                    decreaseQuality(item);
                }

                decreaseSellIn(item);

                if (item.sellIn < 0) {
                    if (!AGED_BRIE.equals(item.name)) {
                        if (!BACKSTAGE_PASSES.equals(item.name)) {
                            decreaseQuality(item);
                        } else {
                            item.quality = MIN_QUALITY;
                        }
                    } else {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    private void updateQualityBackstagePasses(Item item) {
        if (item.sellIn <= 5) {
            increaseQuality(item, 3);
        } else if (item.sellIn <= 10) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item, int i) {
        item.quality = Math.min(item.quality + i, MAX_QUALITY);
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

}

