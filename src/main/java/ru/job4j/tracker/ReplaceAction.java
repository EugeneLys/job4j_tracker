package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Replace item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.findById(id).getName().equals(name)) {
            out.println("Item sucessfully replaced.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
