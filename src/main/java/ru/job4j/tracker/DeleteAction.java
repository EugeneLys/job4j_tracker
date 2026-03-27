package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (tracker.findById(id) != null) {
            out.println("Item successfully deleted.");
        } else {
            out.println("Item was not deleted.");
        }
        tracker.delete(id);
        return true;
    }
}
