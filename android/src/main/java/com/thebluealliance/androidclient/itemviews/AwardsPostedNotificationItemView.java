package com.thebluealliance.androidclient.itemviews;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.thebluealliance.androidclient.R;
import com.thebluealliance.androidclient.helpers.EventHelper;
import com.thebluealliance.androidclient.listeners.GamedayTickerClickListener;
import com.thebluealliance.androidclient.viewmodels.AwardsPostedNotificationViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableFrameLayout;

public class AwardsPostedNotificationItemView extends BindableFrameLayout<AwardsPostedNotificationViewModel> {
    @BindView(R.id.card_header) TextView header;
    @BindView(R.id.details) TextView details;
    @BindView(R.id.notification_time) TextView time;
    @BindView(R.id.summary_container) View summaryContainer;

    public AwardsPostedNotificationItemView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_notification_awards_posted;
    }

    @Override
    public void onViewInflated() {
        ButterKnife.bind(this);
    }

    @Override
    public void bind(AwardsPostedNotificationViewModel model) {
        header.setText(getContext().getString(R.string.gameday_ticker_event_title_format, EventHelper.shortName(model.getEventName()), EventHelper.getShortCodeForEventKey(model.getEventKey()).toUpperCase()));
        details.setText(getContext().getString(R.string.notification_awards_updated_gameday_details));
        time.setText(model.getTimeString());
        summaryContainer.setOnClickListener(new GamedayTickerClickListener(getContext(), model.getIntent()));
    }
}
