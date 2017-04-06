package com.zelimir.android.mvpsampleapp.section;

import android.os.Bundle;

/**
 * Interface which defines objects which are data driven, e.g. they can receive Bundle which
 * contains some data.
 */
public interface DataDriven {

    void setBundle(final Bundle bundle);

}
