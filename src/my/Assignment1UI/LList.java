
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.Assignment1UI;

/**
 *
 * @author js039
 */
public class LList {

    private Link root = null;

    public void AddToList(String value) {
        if (root == null) {
            root = new Link();
            root.name = value;
        } else {
            add(value);
        }

    }

    public void add(String value) {
        recAdd(value, root);
    }

    private void recAdd(String value, Link myLink) {
        if (myLink.nextLink == null) {
            Link temp = new Link();
            temp.name = value;
            myLink.nextLink = temp;
        } else {
            recAdd(value, myLink.nextLink);
        }
    }

    public Link search(String value) {
        return recSearch(root, value);
    }

    private Link recSearch(Link myLink, String value) {
        if (myLink == null) {
            return myLink;
        }
        if (myLink.name.equalsIgnoreCase(value)) {
            return myLink;
        }
        return recSearch(myLink.nextLink, value);

    }

    public void delete(Link toRemove) {
        recDelete(toRemove, root);
    }

    private void recDelete(Link toRemove, Link list) {
        if (list == null) {
            return;
        }
        if (toRemove == root) {
            root = null;
            return;
        }
        
        if (toRemove == list.nextLink) {
            list.nextLink = list.nextLink.nextLink;
            }
        else {
            recDelete(toRemove,list.nextLink);
        }

    }

    public void printOut() {
        recPrintOut(root);
    }

    public void recPrintOut(Link list) {
        if (list != null) {
            System.out.print(" Name " + list.name);
            recPrintOut(list.nextLink);
        }
    }

    public String getcontentstring(Link link, String Contentstring) {
        if (link != null) {
            Contentstring = (link.name) + "\n" + Contentstring;
            return getcontentstring(link.nextLink, Contentstring);
        } else {
            return Contentstring;
        }

    }

    public Link getRoot() {
        return root;
    }

    public Link getLastLink(Link linkParam) {
        if (linkParam.nextLink == null) {
            // this is the last node
            return linkParam;
        } else {
            return getLastLink(linkParam.nextLink);
        }
    }
}
