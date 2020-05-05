import React from 'react';
import {ImageBackground,StyleSheet, View, Text, Button} from 'react-native';

export default function Home({navigation}) {

    const pressHandlerRegister = () => 
    {
        navigation.navigate('Signup')
    }

    const pressHandlerSignin = () => 
    {
        navigation.navigate('Login')
    }
    return(
        <View>
            <ImageBackground source={require("../images/aribabackground.jpg")} style={{width: '100%', height: '100%'}}>
            <Text>{"\n"}</Text>
            <Text>{"\n"}</Text>
            <Text style = {{fontSize:21, color:'#FF7700', fontFamily:'vincHand'}}>       Welcome to Ariba URL shortener</Text>

            <Text>{"\n"}</Text>
            <Button title='Register' onPress={pressHandlerRegister} />

            <Text>{"\n"}</Text>
            <Button title='Sign in' onPress={pressHandlerSignin} />
            </ImageBackground>
        </View>
    )
}
