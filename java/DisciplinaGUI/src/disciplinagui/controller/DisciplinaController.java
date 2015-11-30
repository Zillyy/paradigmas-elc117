/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplinagui.controller;

import disciplinagui.model.Disciplina;
import disciplinagui.model.TableModelDisciplina;
import disciplinagui.view.DisciplinaView;

/**
 *
 * @author andrea
 */

public class DisciplinaController {

    private DisciplinaView view;
    private TableModelDisciplina model;

    public DisciplinaController(DisciplinaView view, TableModelDisciplina model) {
        this.view = view;
        this.model = model;
    }

    public void insert() {
        Disciplina discip = newFromView();
        if (discip != null) {
            model.add(discip);
        }
    }

    public void update() {
        int index = view.getTableDisciplina().getSelectedRow();
        if (index == -1) {
            return;
        }
        Disciplina discip = newFromView();
        if (discip != null) {
            model.update(index, discip);
        }
    }

    public void remove() {
        int index = view.getTableDisciplina().getSelectedRow();
        if (index == -1) {
            return;
        }
        model.remove(index);
    }

    public void select() {
        int index = view.getTableDisciplina().getSelectedRow();
        if (index == -1) {
            return;
        }
        Disciplina discip = model.select(index);
        view.getTextAno().setText(Integer.toString(discip.getAno()));
        view.getComboSemestre().setSelectedIndex(discip.getSemestre() - 1);
        view.getTextNome().setText(discip.getNome());
        view.getTextNota().setText(Float.toString(discip.getNota()));
    }

    public void clear() {
        view.getTextAno().setText("");
        view.getComboSemestre().setSelectedIndex(0);
        view.getTextNome().setText("");
        view.getTextNota().setText("");
    }

    private Disciplina newFromView() {
        try {
            Disciplina discip = new Disciplina();
            discip.setAno(Integer.parseInt(view.getTextAno().getText()));
            discip.setSemestre(view.getComboSemestre().getSelectedIndex() + 1);
            discip.setNome(view.getTextNome().getText());
            discip.setNota(Float.parseFloat(view.getTextNota().getText()));
            return discip;
        } catch (NumberFormatException e) {
            view.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
    }
}
