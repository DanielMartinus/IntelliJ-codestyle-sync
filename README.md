## IntelliJ code style sync
Sync your codestyle with your IntelliJ based IDE from a top level project folder and easily maintain it through git.

### Installation

The plugin is _not yet_ submitted to the IntelliJ repository because there is an alternative way to achieve this supported by JetBrains, [click here to read how](#alternative-way). 

##### Download the plugin

Download the latest version from the release page of this repository: https://github.com/DanielMartinus/IntelliJ-codestyle-sync/releases

##### Load plugin in your IDE

Go to your preferences in your favorite JetBrains IDE and open the **Plugins** section. Choose **Install plugin from disk...** and choose the .zip file you just downloaded. *(don't need to unpack the zip file)*.

### How to use

Restart your IDE. A folder has been created called *.codestyles* at the top level of your project. Put any codestyle in that folder and it will automatically be synced with your codestyles. 

*Sometimes the IDE might need a restart the first time for your codestyle to appear*

Choose your codestyle in **Preferences** > **Editor** > **Code Style** > *the code style should appear in the scheme list*

Each time someone updates the codestyle in your code repository it will automatically sync with the codestyle folder of your IDE. The plugin supports more than one codestyle.

#### Force sync code styles

Go to **tools** > **Sync code styles**

### Alternative way

Since there is a solution supported by JetBrains to share code style on project level and update it through git. I decided not to upload this plugin to the IntelliJ Plugin repository but open source it so others could learn from how to build a simple plugin.

1. Add your codestyle to the **.idea** folder of your project
2. Go to Editor > Code Style > and choose *Manage...* next to the the scheme chooser. 
3. Select **Project**

From now on you are using the code style defined in the .idea folder.

If you want to maintain the codestyle through git you probably have to whitelist your codestyle in your .gitignore since most of the time the .idea folder is fully ignored.
