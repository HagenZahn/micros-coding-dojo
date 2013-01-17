class GildedRose {
    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final int CONCERT_VERY_NEAR = 5;
    public static final int CONCERT_APPROACHING = 10;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {


        if (isRegularItem(item)) {
            decreaseQuality(item);
        }

        if (item.name == AGED_BRIE) {
            increaseQualityAgedBrie(item);
        }

        if (item.name == BACKSTAGE_PASSES) {
            increaseQualityBackstagePasses(item);
        }

        if (item.name != SULFURAS_HAND_OF_RAGNAROS) {
            decreaseSellIn(item);
        }

        if (item.sellIn < 0) {
            if (isRegularItem(item)) {
                decreaseQuality(item);
            }

            if (item.name == BACKSTAGE_PASSES) {
                item.quality = MIN_QUALITY;
            }
            if (item.name == AGED_BRIE) {
                increaseQuality(item);
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityAgedBrie(Item item) {
        increaseQuality(item);
    }

    private void increaseQualityBackstagePasses(Item item) {
        if (item.sellIn <= CONCERT_VERY_NEAR) {
            increaseQuality(item, 3);
        } else if (item.sellIn <= CONCERT_APPROACHING) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item);
        }

    }

    private void increaseQuality(Item item, int i) {

        if (item.quality < MAX_QUALITY)
            item.quality = item.quality + i;


    }

    private boolean isRegularItem(Item item) {
        return item.name != AGED_BRIE && item.name != BACKSTAGE_PASSES && item.name != SULFURAS_HAND_OF_RAGNAROS;
    }

    private void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }


    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

}