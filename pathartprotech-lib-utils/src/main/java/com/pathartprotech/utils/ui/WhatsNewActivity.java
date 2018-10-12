/* Copyright (c) 2010-2011 Pathartprotech androidsoft.org
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.pathartprotech.utils.ui;

import android.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

/**
 * What's New Activity - Display a dialog box for the very first run and for the
 * first run of each update.
 * @author Pathartprotech
 */
public abstract class WhatsNewActivity extends NoTitleActivity
{

    public abstract int getFirstRunDialogTitleRes();

    public abstract int getFirstRunDialogMsgRes();

    public abstract int getWhatsNewDialogTitleRes();

    public abstract int getWhatsNewDialogMsgRes();
    private static final String KEY_VERSION = "version";
    private static final int DEFAULT_VERSION = -1;

    /**
     * {@inheritDoc }
     */
    @Override
    public void onCreate(Bundle icicle)
    {

        super.onCreate(icicle);
        checkLastVersion();

    }

    /**
     * Checks if running a new update or first run
     */
    private void checkLastVersion()
    {
        final int lastVersion = getSavedVersion();
        final int currentVersion = getVersionNumber();
        if (lastVersion < currentVersion)
        {
            int resTitle;
            int resMessage;
            if (lastVersion == DEFAULT_VERSION)
            {
                // This is a new install
                resTitle = getFirstRunDialogTitleRes();
                resMessage = getFirstRunDialogMsgRes();
            }
            else
            {
                // This is an upgrade.
                resTitle = getWhatsNewDialogTitleRes();
                resMessage = getWhatsNewDialogMsgRes();
            }
            // show what's new message
            saveVersion(currentVersion);
            showWhatsNewDialog(resTitle, resMessage);
        }
    }

    /**
     * Gets a version number stored in preferences
     * @return The version number
     */
    private int getSavedVersion()
    {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        return prefs.getInt(KEY_VERSION, DEFAULT_VERSION);
    }

    /**
     * Save a version number into preferences
     * @param version The version number
     */
    private void saveVersion(int version)
    {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        Editor editor = prefs.edit();
        editor.putInt(KEY_VERSION, version);
        editor.commit();
    }

    /**
     * Show teh What's new dialog
     * @param title The dialog's title
     * @param message The dialog's message
     */
    private void showWhatsNewDialog(int title, int message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setIcon(R.drawable.ic_menu_info_details);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.ok),
                new DialogInterface.OnClickListener()
                {

                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    /**
     * Gets the version number
     * @return The version number
     */
    public int getVersionNumber()
    {
        int versionNo = 0;
        PackageInfo pInfo = null;
        try
        {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_META_DATA);
        }
        catch (NameNotFoundException e)
        {
            pInfo = null;
        }
        if (pInfo != null)
        {
            versionNo = pInfo.versionCode;
        }

        return versionNo;
    }
}
