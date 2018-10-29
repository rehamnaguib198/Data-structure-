/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.mailServer.cs18_cs23_cs45_cs52;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IApp;
import eg.edu.alexu.csd.datastructure.mailServer.IContact;
import eg.edu.alexu.csd.datastructure.mailServer.IFilter;
import eg.edu.alexu.csd.datastructure.mailServer.IFolder;
import eg.edu.alexu.csd.datastructure.mailServer.IMail;
import eg.edu.alexu.csd.datastructure.mailServer.ISort;

/**
 *
 * @author HP
 */
public class Iapp implements IApp {

    @Override
    public boolean signin(final String email, final String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean signup(final IContact contact) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setViewingOptions(final IFolder folder, final IFilter filter,
            final ISort sort) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IMail[] listEmails(final int page) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteEmails(final ILinkedList mails) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveEmails(final ILinkedList mails, final IFolder des) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean compose(final IMail email) {
        throw new UnsupportedOperationException();
    }

}
