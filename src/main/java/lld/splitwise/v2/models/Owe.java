package lld.splitwise.v2.models;

public record Owe(User lowerUser, User higherUser, double lowerOwesHigher) {
    @Override
    public String toString() {
        return lowerOwesHigher > 0.0
                ? lowerUser.getId() + " owes " + higherUser.getId() + " : " + lowerOwesHigher
                : higherUser.getId() + " owes " + lowerUser.getId() + " : " + (-lowerOwesHigher);
    }

    public boolean involvesUser(User user) { return lowerUser == user || higherUser == user;}
}
