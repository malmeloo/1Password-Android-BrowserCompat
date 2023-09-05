# 1Password-Android-BrowserCompat

XPosed module for Android that allows using the 1Password browser autofill service on any browser you want!

## Why?
1Password has an autofill service for mobile browsers. After detecting that you are using a
supported browser, it will offer its autofill service which matches against the website that
you are currently on. The problem? This only works for supported browsers! For example, Firefox
and Chrome are supported, but Fennec and Bromite are not.

This lightweight XPosed module hooks into 1Password's browser detection and forcefully enables
browser-like autofill if it detects 

## Which alternative browsers are supported?
Since 1Password does not provide support for these browsers, it is important that the alternative
browser is very similar to its upstream. Simply adding a random app will **not** work.

Currently, only Fennec has been added to this module. Please let me know if you want to
test another browser so I can add it as well!

## A word of caution
Never, **EVER** install random XPosed modules, especially when they inject into your password
manager. This module is open source, so please read the source code if you're able to
so you understand how it works.

This module does NOT verify app signatures. Theoretically, any app can disguise as a 3rd party
browser and trigger 1Password's special browser treatment, which might have unexpected consequences.
The risk is up to you to judge.
