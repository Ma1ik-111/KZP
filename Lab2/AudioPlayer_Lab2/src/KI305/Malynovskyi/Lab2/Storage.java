package KI305.Malynovskyi.Lab2;

/**
 * Class <code>Storage</code> represents a storage device where audio files live.
 */
class Storage {
    private final String name;
    private final int capacityMb;
    private int usedMb = 0;

    public Storage(String name, int capacityMb) {
        this.name = name;
        this.capacityMb = capacityMb;
    }

    public boolean allocate(int sizeMb) {
        if (usedMb + sizeMb > capacityMb) return false;
        usedMb += sizeMb;
        return true;
    }

    public void free(int sizeMb) {
        usedMb = Math.max(0, usedMb - sizeMb);
    }

    public String getInfo() {
        return name + " [" + usedMb + "/" + capacityMb + " MB]";
    }
}
