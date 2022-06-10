package com.nurdev.landmeasurement;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.cardview.widget.CardView;


import com.onesignal.OneSignal;


//public class MainActivity extends Activity implements RewardedVideoAdListener {
    public class MainActivity extends Activity {
    private static final String ONESIGNAL_APP_ID = "908db8ae-8feb-4174-9899-d944c0ef8c62";
    private CardView b1,b2,b3,b4,b5,b6,b7,b8,mail;
    private Button appinfo,playvideo;
   // private AdView mAdView;
  //  private RewardedVideoAd mRewardedVideoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        setContentView(R.layout.activity_main);
   /*     MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/
/*
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                Toast.makeText(MainActivity.this,"No Internet Connection !",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Toast.makeText(MainActivity.this,"Thanks for donate",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Toast.makeText(MainActivity.this,"Thanks for donate",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Toast.makeText(MainActivity.this,"CLosed",Toast.LENGTH_LONG).show();
            }
        });
*/


 /*       AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2274616816336456/3730665094");

        MobileAds.initialize(this, "ca-app-pub-2274616816336456~7673779534");
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();*/
        b1=(CardView)findViewById(R.id.landCId);
        b2=(CardView)findViewById(R.id.landDId);
        b3=(CardView)findViewById(R.id.soidCalId);
        b4=(CardView)findViewById(R.id.triCalId);
        b5=(CardView)findViewById(R.id.unitId);
        b6=(CardView)findViewById(R.id.infoId);
        b7=(CardView)findViewById(R.id.gulCalId);
        b8=(CardView)findViewById(R.id.donate);
        mail=(CardView)findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,feedback.class));
            }
        });
        appinfo=(Button)findViewById(R.id.appinfo);
        playvideo=(Button)findViewById(R.id.playvideo);
        playvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mRewardedVideoAd.show();
            }
        });
        appinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,AppInfo.class));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,LandCalculator.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,LandShareCalculator.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,SoilCalculator.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this, Wood.class));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,UnitCalculator.class));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,LandInformation.class));
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,Wood2Activity.class));
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }*/
                startActivity(new Intent(MainActivity.this,DonateActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure to do exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

/*
    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-2274616816336456/2919791082",
                new AdRequest.Builder().build());
    }
*/





    public void share(View view) {
        String shareBody ="Enter this link to download the app - https://play.google.com/store/apps/details?id="+getPackageName();
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Friends (Open it in Google Play Store to Download the Application)");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }

    public void rateme(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    public void more(View view) {
        startActivity(new Intent(MainActivity.this,MoreApps.class));

    }

    public void privacy(View view) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("To know more about this: Send us an E-mail at: support@TechZweb.com or visit https://TechZweb.com\n" +
                "\nPrivacy Policy & App Related Query\n"+
                "\nApp ask for storage or SDcard permission so that, the app uses your data only once ,not many times over. Because, after first launch of this app it does require some information to download so that it can function properly. Now do you want to spend your data everytime you read or see a page or screen? Of course not, that's why app asks for sdcard or storage permission. In this case application will download information and save it to your storage or sdcard, so that it doesn’t have to download same thing second time. Why does this app has so many ads? Ads are shown, so that YOUR hard earned money stays in your pocket. You’ve surely seen those paid apps around and you have to buy them to use them. You can find those apps in the ‘Top Paid’ section of Google Play. Those apps have no ads whatsoever. Because they get their money through your wallet. Making an app is no easy task. It takes significant amount of cost, time and effort to make those. And the reason you can get those apps for free, is because we show you advertisements in our apps. We admit that sometimes ads can be annoying and disturbing, but if it weren’t for those ads, you would have to pay for those applications. The ads allows the app developers to have something in return for their efforts and hardwork. It also enables them to carry out their work to further stage, making upgrades, on the existing apps as well as creating new apps now and then. To continue developing free apps for all of us we hope you will endure this little annoyance. Thank you. What information does this app collect? This app collect your location, as well as some of your device information that we get from android os such as device brand, model, version... etc. This application might also ask you to enter your email address or phone number based on your application usage, so you can enlist in our subscriber list which you can omit or ignore. You can also unsubscribe anytime you want by emailing us and by uninstalling this application. Does this app collect your device advertising identifier or any personally identifiable information? Yes, this app will ask google play services to give your device advertising identifier for its uses. Advertising identifier is used by google, facebook and other similar services to give you the best ad experience while also maintaining a good user experience. You can always change your device advertising identifier whenever you want. What do we do with those information? As you know this application is totally free. But to develop these kind of application we need operational cost as well as development cost. We get those cost from ads which we deliver within our application. But when we serve ad to you we need to make sure you don't see irrelevant ads. For example: A restaurant in france is not relevant to the people of brazil. It's best to show ads that are relevant to you. So to do that, we take help from your data, so that we can deliver the best ad experience without annoying you. Do we share those information with any untrusted party? No, we do not share these data with anyone that we do not trust or does not have a long running reputation for user privacy. To deliver the best and relevant ad experience to you, sometimes we do need to take help from trusted third party organization such as(Google, Facebook, Amazon .... etc). These organization can help us only when we share certain information with them. How do i opt out? We collect some of the information that are generally available when you first launch this application. And these data are not directly associated with you, rather they are android system specific information. So, if you just delete or uninstall this application, you are automatically opted out. But to be opted out from our subscriber list you can email us by requesting to remove your info from our list. And we will remove all the associated data of you from our list. App keep asking for a review or rate us, what’s that all about? So that the app makers can work on new and better apps. When you’re rating an app with 5 stars, please be sure to give us any suggestion if it comes to your mind. Sometimes i see youtube, facebook videos, pages or websites even though the app is not for youtube or websites, why is that? These are also kinds of ads. But they are put in such a way that you wouldn’t be annoyed or disturbed. Meaning, they won’t come in front of you all of a sudden.");
        builder.setCancelable(true);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void facebook(View view) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Like & Join With Us.");
        builder.setCancelable(true);
        builder.setNegativeButton("ফেসবুক পেজ লাইক করুন", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/TechZwebapp")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/TechZwebapp")));
                }
            }
        });
        builder.setPositiveButton("Join ফেসবুক গ্রূপ ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/groups/techzweb")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/groups/techzweb")));
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
/*

    @Override
    public void onRewardedVideoAdLoaded() {

        playvideo.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRewardedVideoAdOpened() {
        playvideo.setVisibility(View.GONE);
    }

    @Override
    public void onRewardedVideoStarted() {
        playvideo.setVisibility(View.GONE);
    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
        playvideo.setVisibility(View.GONE);
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        playvideo.setVisibility(View.GONE);
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        loadRewardedVideoAd();
        playvideo.setVisibility(View.GONE);
    }

    @Override
    public void onRewardedVideoCompleted() {
        playvideo.setVisibility(View.GONE);
    }
*/


    public void subscribe(View view) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Subscribe US");
        builder.setCancelable(true);
        builder.setNegativeButton("Telegram", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://t.me/techzweb")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://t.me/techzweb")));
                }
            }
        });
        builder.setPositiveButton("Youtube", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/channel/UCNSoc9zPOjJSy6ohb4UI7Mw")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/channel/UCNSoc9zPOjJSy6ohb4UI7Mw")));
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
