package com.example.materialsidenavui.model;

public class DashboardMenu {
    String menuName;
    int id;
    int icon;
    public boolean isChecked;
    
    public DashboardMenu() {
    }

    public DashboardMenu(String menuName, int icon) {
        this.menuName = menuName;
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public boolean isSelectable() {
        return true;
    }

}

