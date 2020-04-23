import React, { Component, useState } from 'react';
import { Text, TextInput, View, Button } from 'react-native';

export default function Login({navigation}) {
  const [textUsername, setTextUsername] = useState('');
  const [textPassword, setTextPassword] = useState('');

  const pressHandlerLogin = () => 
  {
        //Enter login logic here

        try {
          fetch('http://192.168.1.23:8080/getUser', {
              method: 'POST',
              headers: {
                  Accept: 'application/json',
                  'Content-Type': 'application/json',
              },
              body: JSON.stringify(
                  {
                      "username":textUsername,
                      "password":textPassword
                  }
              ),
          }).then((response) => response.json())
            .then((responseJson) => {
              console.log(responseJson.login)
              if(responseJson.login === 'true')
              {
                navigation.navigate('LinkOptions',{username:textUsername})
              }
            })
            .catch((error) => {
              console.error(error);
            });
        console.log('user successfully signed up!: ', success)
      } catch (err) {
        console.log('error signing up: ', err)
      }
  }


  return (
    <View style={{padding: 10}}>
      <Text>{"\n"}</Text>
      <TextInput
        style={{height: 40, borderColor:'black', borderStyle: 'solid', borderWidth:3}}
        placeholder="Enter username"
        onChangeText={textUsername => setTextUsername(textUsername)}
        defaultValue={textUsername}
      />
      <Text>{"\n"}</Text>
      <TextInput
        style={{height: 40, borderColor:'black', borderStyle: 'solid', borderWidth:3}}
        placeholder="Enter password"
        onChangeText={textPassword => setTextPassword(textPassword)}
        defaultValue={textPassword}
      />

      <Text>{"\n"}</Text>
      <Button title='Login' onPress={pressHandlerLogin} />


    </View>
  );
}