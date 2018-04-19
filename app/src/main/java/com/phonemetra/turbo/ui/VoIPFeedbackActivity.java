package com.phonemetra.turbo.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.phonemetra.turbo.messenger.AndroidUtilities;
import com.phonemetra.turbo.messenger.LocaleController;
import com.phonemetra.turbo.messenger.MessagesController;
import com.phonemetra.turbo.messenger.R;
import com.phonemetra.turbo.tgnet.ConnectionsManager;
import com.phonemetra.turbo.tgnet.RequestDelegate;
import com.phonemetra.turbo.tgnet.TLObject;
import com.phonemetra.turbo.tgnet.TLRPC;
import com.phonemetra.turbo.ui.ActionBar.AlertDialog;
import com.phonemetra.turbo.ui.ActionBar.Theme;
import com.phonemetra.turbo.ui.Components.BetterRatingView;
import com.phonemetra.turbo.ui.Components.LayoutHelper;
import com.phonemetra.turbo.ui.Components.voip.VoIPHelper;

public class VoIPFeedbackActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		super.onCreate(savedInstanceState);

		overridePendingTransition(0, 0);

		setContentView(new View(this));

		VoIPHelper.showRateAlert(this, new Runnable(){
			@Override
			public void run(){
				finish();
			}
		}, getIntent().getLongExtra("call_id", 0), getIntent().getLongExtra("call_access_hash", 0));
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, 0);
	}
}
