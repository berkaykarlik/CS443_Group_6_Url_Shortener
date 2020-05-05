import React from 'react';
import {StyleSheet, View, Text, Button} from 'react-native';

export default function LinkOptions({navigation}) {

    const pressHandlerShortLink = () => 
    {
        navigation.navigate('ShortLink',{username:navigation.getParam('username')})

    }

    const pressHandlerCustomLink = () => 
    {
        navigation.navigate('CustomLink',{username:navigation.getParam('username')})
    }
    const pressHandlerLinkAnalytics = () => 
    {
        navigation.navigate('LinkAnalytics',{username:navigation.getParam('username')})
    }

    return(
        <View>

            <Text>{"\n"}</Text>
            <Text>Welcome {navigation.getParam('username')}</Text>

            <Text>{"\n"}</Text>
            <Button title='Create Short Link' onPress={pressHandlerShortLink} />

            <Text>{"\n"}</Text>
            <Button title='Create Custom Short Link' onPress={pressHandlerCustomLink} />

            <Text>{"\n"}</Text>
            <Button title='See Link Analytics' onPress={pressHandlerLinkAnalytics} />
        </View>
    )
}