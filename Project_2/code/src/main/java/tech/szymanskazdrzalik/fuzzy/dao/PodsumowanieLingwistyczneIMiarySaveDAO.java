package tech.szymanskazdrzalik.fuzzy.dao;

import tech.szymanskazdrzalik.fuzzy.gui.PodsumowanieLingwistyczneIMiary;

public interface PodsumowanieLingwistyczneIMiarySaveDAO extends SaveDAO<PodsumowanieLingwistyczneIMiary> {
    @Override
    void Save(PodsumowanieLingwistyczneIMiary podsumowanieLingwistyczneIMiary);
}
